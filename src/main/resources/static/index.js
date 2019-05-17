function requestResults() {
    var inputExpr = $('#expression').val();
    $.ajax({
        url: "/calculate",
        type: "GET",
        data: {expression: inputExpr},
        success: function(operationResult) {
            $('#expression').val(operationResult);
        },
        error: function(error) {
            alert(error);
        }
    });
}