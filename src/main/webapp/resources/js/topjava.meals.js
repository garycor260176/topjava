const mealAjaxUrl = "profile/meals/";

// https://stackoverflow.com/a/5064235/548473
const ctx = {
    ajaxUrl: mealAjaxUrl,
    updateTable: function () {
        $.ajax({
            type: "GET",
            url: mealAjaxUrl + "filter",
            data: $("#filter").serialize()
        }).done(updateTableByData);
    }
};

function clearFilter() {
    $("#filter")[0].reset();
    $.get(mealAjaxUrl, updateTableByData);
}

$(function () {
    makeEditable({
        "columns": [
            {
                "data": "dateTime",
                "render": function (date, type, row) {
                    if (type === 'display') {
                        return formatDate(date);
                    }
                    return date;
                }
            },
            {
                "data": "description"
            },
            {
                "data": "calories"
            },
            {
                "render": renderEditBtn,
                "defaultContent": "",
                "orderable": false
            },
            {
                "render": renderDeleteBtn,
                "defaultContent": "",
                "orderable": false
            }
        ],
        "order": [
            [
                0,
                "desc"
            ]
        ],
        "createdRow": function (row, data, dataIndex) {
            $(row).attr("data-meal-excess", data.excess);
        }
    });

    const dateOptions = {
        timepicker: false,
        format: 'Y-m-d',
        formatDate: 'Y-m-d',
    };
    $('#startDate').datetimepicker({
        ...dateOptions
    });
    $('#endDate').datetimepicker({
        ...dateOptions
    });

    const timeOptions = {
        datepicker: false,
        format: 'H:i'
    };
    $('#startTime').datetimepicker({
        ...timeOptions
    });
    $('#endTime').datetimepicker({
        ...timeOptions
    });

    $('#dateTime').datetimepicker({
        format: 'Y-m-d H:i'
    });
});
