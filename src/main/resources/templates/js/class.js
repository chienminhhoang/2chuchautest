function openModal() {
    $.ajax(
        {
            type: "Get",
            url: "http://localhost:8081/api/Class",
            success: function (data) {
                let content = ""
                for (let i = 0; i < data.length; i++) {
                    content += ' <option value="' + data[i].id + '">' + data[i].name +
                        '</option>'
                }}
        }
    )
    $('#myModal').modal('show');
}

// load dữ liệu
LoadData()

// load dữ liệu của class trong db
function loadData() {
    $.ajax({
        type: "GET",
        url: "http://localhost:8081/api/class",
        success: function (data) {
            loadTable(data)
        }
    })
}

// rollback
function loadTable(list) {
    let content = "";
    for (let i = 0; i < list.length; i++) {
        content += "<tr>"
        content += "<th>" + (i + 1) + "</th>"
        content += "<th>" + list[i].name + "</th>"
        content += "<th><button onclick='getClass(" + list[i].id + ")'>Update</button></th>"
        content += "<th><button onclick='deleteClass(" + list[i].id + ")'>Delete</button></th>"
        content += "</tr>"
    }
    document.getElementById("list-class").innerHTML = content;
}

//createClass
function createClass() {
    let name = $('#name').val()
    let classes = {
        name: name
    }
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        }, type: "POST",
        data: JSON.stringify(classes),
        //tên API
        url:"http://localhost:8081/api/Class/create-class",
        //khi create successfully
        success: function (){
            swal.fire({
                position: 'center',
                icon: 'success',
                title: 'Tạo mới thành công',
                showConfirmButton: false,
                timer: 1500
            })
            setTimeout(loadData, 2000);
            $('#myModal').modal('hide');
        }

    });
    // chặn sự kiện mặc định
    event.preventDefault();
}
function getClass(idClass) {
    $.ajax({
        type: "GET",
        url: "http://localhost:8081/api/Class" + idClass,
        success: function (data) {
            openModal()
            document.getElementById("idHuman").innerHTML = " <th>ID</th>\n" +
                " <td><label><input type=\"text\" readonly id=\"id\"></label></td>";
            document.getElementById("id").value= idClass;
            document.getElementById("name").value= data.name;
            document.getElementById("title-button").innerHTML = "Update";
            document.getElementById("title-button").setAttribute("onclick","updateHuman()");

        }
    })
}
function updateClass(){
    let id = document.getElementById("id").value;
    console.log(id)
    let name = $('#name').val()
    let classes = {
        id:id,
        name: name
    }
};
$.ajax({
    headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
    },
    type: "PUT",
    data: JSON.stringify(classes),
    url:"http://localhost:8081/api/Class/update-class",
    success: function () {
        loadData()
        document.getElementById("name").value = "";
        $('#myModal').modal('hide');
    }

})
function  deleteClass(id){
    swal.fire({
        title: 'Bạn có chắc muốn xóa ?',
        text: "Bạn không thể khôi phục dữ liệu sau khi xóa  !",
        icon: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        confirmButtonText: 'Xóa!'}).then((result) => {
        if (result.isConfirmed) {
            Swal.fire(
                'Deleted!',
                'Your file has been deleted.',
                'success',
                $.ajax({
                    type: "DELETE",
                    url: "http://localhost:8081/api/Class/delete-class" + id,
                    success: function () {
                        Swal.fire({
                            position: 'top-end',
                            icon: 'success',
                            title: 'Xóa thành công',
                            showConfirmButton: false,
                            timer: 1500
                        })
                        loadData()
                    }

                })
            )
        }
    })
}
