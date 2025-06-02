<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.datatables.net/v/bs5/jq-3.7.0/dt-2.0.6/datatables.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.datatables.net/2.0.7/css/dataTables.dataTables.css">
    <link rel="stylesheet" href="https://cdn.datatables.net/buttons/3.0.2/css/buttons.dataTables.css">

    <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
    <script src="https://cdn.datatables.net/v/dt/dt-2.0.6/datatables.min.js"></script>
    <script src="https://cdn.datatables.net/buttons/3.0.2/js/dataTables.buttons.js"></script>
    <script src="https://cdn.datatables.net/buttons/3.0.2/js/buttons.dataTables.js"></script>

    <title>Quản lý Đặt Trước - HandmadeStore</title>
    <style>
        body {
            background-color: #e5e5e5;
            color: #eb1616;
            font-family: "Open Sans", sans-serif;
            font-weight: bold;
            font-size: 16px;
            margin: 0;
        }

        .header {
            margin-top: 20px;
        }

        .header h2 {
            text-align: center;
        }

        .data_table {
            background-color: #FFFFFF;
            padding: 15px;
            box-shadow: 1px 3px 5px #aaa;
            border-radius: 5px;
        }
    </style>
</head>
<body>
    <div class="container-fluid w-100 my-0 mt-2">
        <div class="row">
            <div class="header">
                <h2>Quản lý Đặt Trước</h2>
            </div>

            <div class="col-12">
                <div class="data_table mt-2">
                    <table id="table-preorder" class="display table table-striped table-hover table-bordered">
                        <thead class="table-dark">
                            <tr>
                                <th>Khách hàng</th>
                                <th>Tên sản phẩm</th>
                                <th>Số lượng đặt trước</th>
                            </tr>
                        </thead>
                    </table>
                </div>
            </div>
        </div>
    </div>

    <script>
        $(document).ready(function () {
            $("#table-preorder").DataTable({
                paging: false,
                scrollCollapse: true,
                scrollY: '50vh',
                language: {
                    search: "Tìm kiếm:",
                }
            });
        });
    </script>
</body>
</html> 