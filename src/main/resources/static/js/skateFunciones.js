function bringCategoryInformation(){
    $.ajax({
        url:"http://localhost:8080/api/Category/all",
        type:"GET",
        datatype:"JSON",
        success:function(answer){
            console.log(answer);
            paintAnswer(answer);
        }
    });
}

function paintAnswer(answer){
    let myTable="<table>";
    for(i=0; i<answer.length;i++){
        myTable+="<tr>";
        myTable+="<td>"+answer[i].name+"</td>";
        myTable+="<td>"+answer[i].description+"</td>";
        myTable+="</tr>";
    }
    myTable+="</table>";
    $("#answer1").append(myTable);
}