function linkRequestResults() {
    // var form = $('#tweet-form');
    var expression = $('#display').val();
    $.ajax({
        url: "/calculate/" + expression,
        type: "GET",
        success: function(operationResult) {
            $('#display').val(operationResult);
        },
        error: function(error) {
            alert("error");
        }
    });
}