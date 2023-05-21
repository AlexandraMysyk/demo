# const express = require('express');
# const app = express();
# const sql = require('mssql');

# const config = {
#   user: 'username',
#   password: 'password',
#   server: 'localhost',
#   database: 'database_name'
# };
#     // "cors": "^2.8.5",
# // app.use(cors());
# app.get('/api/select-from-text', (req, res) => {
#   sql.connect(config, function(err) {
#     if (err) console.log(err);

#     var request = new sql.Request();
#     request.query('SELECT * FROM Text', function(err, recordset) {
#       if (err) console.log(err);

#       res.send(recordset);
#     });
#   });
# });

# app.listen(3000, () => {
#   console.log('Сервер запущено на порту 3000');
# });