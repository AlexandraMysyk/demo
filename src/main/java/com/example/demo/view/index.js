// reuire the dependencies just installed from above commands
const sql = require('mssql/msnodesqlv8');

//create a database configuration 

var config = {

       server : "DESKTOP-T6QO5K0\\SQLEXPRESS", // eg:: 'DESKTOP_mjsi\\MSSQLEXPRESS'
      databse: "StudyHub",
      user :'alina',      // please read above note
      password:"1111",   // please read above note
     options :{
       trustedConnection:true,
     },
    driver:"msnodesqlv8",
 }

//note: please make double ( \\ ) before your instance name
//if you get confused then please watch the video link at the bottom you can see in details about this

// now make the connections as 

sql.connect(config,function(err){
    if(err)console.log(err);

    // make a request as

    var request = new sql.Request();

   //make the query

    var query = "Select* from Text";  // eg : "select * from tbl_name"
    var textName = "text2";
    var textLevel = "A3";
    var text = "jyjnhfgdewsdfgbhnjkkjhgfds";
    var admin = 1;
     console.log(textName, textLevel, text, admin);
   
   const sql = require("msnodesqlv8");
   const connectionstring = "server=.;Database=StudyHub;Trusted_Connection=Yes;Driver={SQL Server Native Client 11.0};";
     query = "insert into Text(name,content,complexity_level,fk_admin) values('"+textName+"','"+text+"', '"+textLevel+"',"+admin+")";
   sql.query(connectionstring, query, (err, rows) => { console.log(rows);});
   

});
