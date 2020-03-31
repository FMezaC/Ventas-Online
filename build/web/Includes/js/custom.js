function ValidarForm() {
    var idProd = document.getElementById('CodProd');
    if (idProd.value === null || idProd.value === '') {
        alert('Ingrese Codigo Producto');
        return false;
    }
}

function ValidPeod() {
    var Stock = document.getElementById('Stock');
    if (Stock.value === '0') {
        alert('El Producto no dispone de Stock');
        return false;
    }
}


$("#table tr").click(function () {
    var value = $(this).find('td:first').html();
    document.getElementById('idP').value = value;
    $.ajax({
        type: "POST",
        async: true,
        date: value
    });
});






