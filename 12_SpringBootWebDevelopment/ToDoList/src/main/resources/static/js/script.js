$(function(){

    //del task
    $(document).on('click', '.close',function(){
        var id = $(this).parent().attr("id");
        var xhr = new XMLHttpRequest();
        xhr.open('DELETE', '/tasks/' + id, true);
        xhr.onreadystatechange = () => {
                if (xhr.readyState === 4) {
                    this.parentElement.parentElement.removeChild(this.parentElement);
                }
              }
        xhr.send();
    });

    //change status
    $(document).on('click', '#myUL li',function(){
        var id = $(this).attr("id");
        $.ajax({
            method: "PUT",
            url: "/tasks/" + id
        });
    });

    // Create a "close" button and append it to each list item
    var myNodelist = document.getElementsByTagName("LI");
    var i;
    for (i = 0; i < myNodelist.length; i++) {
        var span = document.createElement("SPAN");
        var txt = document.createTextNode("\u00D7");
        span.className = "close";
        span.appendChild(txt);
        myNodelist[i].appendChild(span);
    }

    // Add a "checked" symbol when clicking on a list item
    var list = document.querySelector('ul');
    var id = $(this).parent().attr("id");
    list.addEventListener('click', function(ev) {
        if (ev.target.tagName === 'LI') {
            ev.target.classList.toggle('checked');
        }
    }, false);

});

// Create a new list item when clicking on the "Add" button
function newElement() {
    var li = document.createElement("li");
    var inputValue = document.getElementById("myInput").value;
    var inputDate = document.getElementById("myInputDate").value;
    var dataForm = $('#myDIV form').serialize();
    console.log(dataForm);
    $.ajax({
        method: "POST",
        url: "/tasks",
        data: dataForm,
    });
    var dateParse = new Date(inputDate).toLocaleDateString('ru-RU', {
        day : 'numeric',
        month : 'long',
        year : 'numeric'
    });
    var t = document.createTextNode(inputValue + " до " + dateParse);
    li.appendChild(t);
    if (inputValue === '') {
        alert("Напишите название дела!");
    } else {
        if (inputDate === '') {
            alert("Введите дату!");
        } else {
            document.getElementById("myUL").appendChild(li);
            document.getElementById("myInput").value = "";
            document.getElementById("myInputDate").value = "";
        }
    }

    var span = document.createElement("SPAN");
    var txt = document.createTextNode("\u00D7");
    span.className = "close";
    span.appendChild(txt);
    li.appendChild(span);

    for (i = 0; i < close.length; i++) {
        close[i].onclick = function() {
            var div = this.parentElement;
            div.style.display = "none";
        }
    }
}