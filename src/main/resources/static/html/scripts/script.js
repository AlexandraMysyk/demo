function clearFields() {
    document.getElementById("text-name").value = "";
    document.getElementById("text-level").selectedIndex = 0;
    document.getElementById("text").value = "";
  }
// need add realisation
  function addText() {

  }
  function deleteText() {}

//add realisation
function returnToList(){

}
//add realisation
function viewText(){

}
//add realisation
function open_list_text(){
if (window.location.href.includes("Edit_text.html")) {
    window.location.href = "List_of_texts.html";
} else if (window.location.href.includes("Text.html")) {
  window.location.href = "Texts.html";
}

}
function returnToTaskList(){
  if (window.location.href.includes("Task.html") || window.location.href.includes("Task2.html")) {
      window.location.href = "Tasks.html";
  } 
  }
function editText(){}
function handleEditButtonClick() {
  const selectedText = document.querySelector('input[name="text-item"]:checked');
  if (selectedText) {
    window.location.href = "Edit_text.html";
    
    document.addEventListener("DOMContentLoaded", function() {
      fillForm();
    });
  } else {
    // Показати popup
    const popup = document.getElementById("select_text");
    const close = document.querySelector(".close");
    popup.style.display = "block";
    // Закрити popup при натисканні на хрестик
    close.addEventListener("click", function() {
      popup.style.display = "none";
    });
  }
}
function handleOpenButtonClick() {
  const selectedText = document.querySelector('input[name="text-item"]:checked');
  if (selectedText) {
    if (window.location.href.includes("Texts.html")){
      window.location.href = "Text.html";
    }
  } else {
    // Показати popup
    const popup = document.getElementById("select_text");
    const close = document.querySelector(".close");
    popup.style.display = "block";
    // Закрити popup при натисканні на хрестик
    close.addEventListener("click", function() {
      popup.style.display = "none";
    });
  }
}
function openCurTask() {
  const taskKindInputs = document.getElementsByName('task-kind');
  const selectedText = document.querySelector('input[name="task-item"]:checked');
  if (selectedText) {
  for (let i = 0; i < taskKindInputs.length; i++) {
    if (taskKindInputs[i].checked) {
      const taskKindValue = taskKindInputs[i].value;
      
      if (taskKindValue === 'insert-word') {
        window.location.href = 'Task.html';
      } else if (taskKindValue === 'flash-card') {
        window.location.href = 'Task2.html';
      }
      
      break;
    }
  }}else {
    // Показати popup
    const popup = document.getElementById("select_task");
    const close = document.querySelector(".close");
    popup.style.display = "block";
    // Закрити popup при натисканні на хрестик
    close.addEventListener("click", function() {
      popup.style.display = "none";
    });
  }
}
function handleDeleteButtonClick() {
  const selectedText = document.querySelector('input[name="text-item"]:checked');
  if (selectedText) {
    // Показати popup
    const popup = document.getElementById("delete_text");
    const close = document.querySelector(".close");
    popup.style.display = "block";
  } else {
    // Показати popup
    const popup = document.getElementById("select_text");
    const close = document.querySelector(".close");
    popup.style.display = "block";
    // Закрити popup при натисканні на хрестик
    close.addEventListener("click", function() {
      popup.style.display = "none";
    });
  }
}
function fillForm() {
  const data = {
    "textName": "The Impact of Technology on Society",
    "textLevel": "advanced",
    "text": "Technology has revolutionized the way we live, work, and communicate. From smartphones and social media to cloud computing and artificial intelligence, we are now more connected and empowered than ever before. As we continue to innovate and push the boundaries of what's possible, it's important that we also consider the ethical and social implications of these advances. By working together, we can harness the power of technology for good and create a brighter, more sustainable future for all."  };
  document.getElementById("text-name").value = data.textName;
  document.getElementById("text-level").value = data.textLevel;
  document.getElementById("text").value = data.text;
}


function convertToCEFR() {
  switch (document.getElementById("text-level").value) {
    case "beginner":
      return "A1";
    case "pre-intermediate":
      return "A2";
    case "intermediate":
      return "B1";
    case "upper-intermediate":
      return "B2";
    case "advanced":
      return "C1";
    case "profficiency":
      return "C2";
    default:
      return "";
  }
}
function addTextToDataBase() {
  // var textName = document.getElementById("text-name").value;
  // var textLevel = convertToCEFR();
  // var text = document.getElementById("text").value;
  // var admin = 1;//getCurrentAdmin()//document.getElementById("admin").value;
 var textName = "text2";
 var textLevel = "A3";
 var text = "jyjnhfgdewsdfgbhnjkkjhgfds";
 var admin = 1;
  console.log(textName, textLevel, text, admin);

const sql = require("msnodesqlv8");
const connectionstring = "server=.;Database=StudyHub;Trusted_Connection=Yes;Driver={SQL Server Native Client 11.0};";
 const query = "insert into Text(name,content,complexity_level,fk_admin) values('"+textName+"','"+text+"', '"+textLevel+"',"+admin+")";
sql.query(connectionstring, query, (err, rows) => { console.log(rows);});
}

function wrapWordsInSpans(text) {
  // Розбиваємо текст на окремі слова за допомогою методу split()
  const words = text.split(' ');

  // Створюємо новий масив, який міститиме HTML-елементи для кожного слова
  const wordSpans = words.map(word => `<span class="word">${word} </span>`);

  // Повертаємо рядок, який містить HTML-елементи <span> для кожного слова
  return wordSpans.join('');
}
function getTr(){
let m_word = word.innerHTML.trim();
        fetch(`${url}${m_word}`)
          .then((response) => response.json())
          .then((data) => {
            console.log(data);
            result[0] = m_word;
            result[1] = data[0].meanings[0].definitions[0].definition;
          })
          .catch(() => {
            result = `Couldn't Find The Word`;
          });
        if (!m_word) {
          return;
        }

        const apiUrl = `https://api.mymemory.translated.net/get?q=${m_word}&langpair=${langFrom}|${langTo}`;
        fetch(apiUrl)
          .then((response) => response.json())
          .then((data) => {
            const translatedText = data.responseData.translatedText;
            result[2] = translatedText + " ";
            console.log(result[2]);
          })
          .catch((error) => console.error(error));

        return  result[2]; }
