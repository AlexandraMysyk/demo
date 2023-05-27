function clearFieldsAfter() {
  const popup = document.getElementById("select_task");
  const close = document.querySelector(".close");
  popup.style.display = "block";
  // Закрити popup при натисканні на хрестик
  close.addEventListener("click", function () {
    popup.style.display = "none";
    document.getElementById("text-name").value = "";
    document.getElementById("text-level").selectedIndex = 0;
    document.getElementById("text").value = "";
  });

}
function clearFields() {

  document.getElementById("text-name").value = "";
  document.getElementById("text-level").selectedIndex = 0;
  document.getElementById("text").value = "";
}
// need add realisation
function addText() {

}
function deleteText() {
  console.log(JSON.parse(localStorage.getItem("jsonTexts"))[getTextIndex()]);
}

function getTextIndex() {
  var elements = document.querySelectorAll('input[name="text-item"]');

  // Знайти індекс обраного елемента
  var selectedIndex = -1;
  for (var i = 0; i < elements.length; i++) {
    if (elements[i].checked) {
      selectedIndex = i;
      break;
    }
  }
  return selectedIndex;
}
//add realisation
function returnToList() {

}
//add realisation
function viewText() {

}
//add realisation
function open_list_text() {
  if (window.location.href.includes("Edit_text.html")) {
    window.location.href = "List_of_texts.html";
  } else if (window.location.href.includes("Text.html")) {
    window.location.href = "Texts.html";
  }

}
function returnToTaskList() {
  if (window.location.href.includes("Task.html") || window.location.href.includes("Task2.html")) {
    window.location.href = "Tasks.html";
  }
}
function editText() { }
function handleEditButtonClick() {
  const selectedText = document.querySelector('input[name="text-item"]:checked');

  if (selectedText) {
    const data = JSON.parse(localStorage.getItem("jsonTexts"))[getTextIndex()];
    localStorage.setItem("jsonText",JSON.stringify(data));
           
    window.location.href = "Edit_text.html";

    // document.addEventListener("DOMContentLoaded", function () {
    //   fillForm(data);
    // });
  } else {
    // Показати popup
    const popup = document.getElementById("select_text");
    const close = document.querySelector(".close");
    popup.style.display = "block";
    // Закрити popup при натисканні на хрестик
    close.addEventListener("click", function () {
      popup.style.display = "none";
    });
  }
}
function handleOpenButtonClick() {

  const radioButtons = document.querySelectorAll('input[name="text-item"]');
  let selectedText = '';
  let selectedLevel = '';
  radioButtons.forEach(radioButton => {
    if (radioButton.checked) {
      const liElement = radioButton.parentNode;
      selectedText = liElement.textContent.trim();
      // //console.log(selectedText);
    }
  });


  // selectedLevel =  selectElement.options[selectElement.selectedIndex].textContent;
  // //console.log(getSelectedForReadTextLevel());
  // selectedLevel = document.querySelectorAll('input[name="text-level"]');
  // //console.log(selectedLevel);
  if (selectedText) {
    if (window.location.href.includes("Texts.html")) {
      //console.log(getSelectedForReadTextLevel());
      //console.log(getSelectedForReadTextId());
      setSelectedForReadTextName(selectedText);
      console.log(getSelectedForReadTextName());
      console.log(selectedText);
      // window.location.href = "Text.html";
    }
  } else {
    // Показати popup
    const popup = document.getElementById("select_text");
    const close = document.querySelector(".close");
    popup.style.display = "block";
    // Закрити popup при натисканні на хрестик
    close.addEventListener("click", function () {
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
    }
  } else {
    // Показати popup
    const popup = document.getElementById("select_task");
    const close = document.querySelector(".close");
    popup.style.display = "block";
    // Закрити popup при натисканні на хрестик
    close.addEventListener("click", function () {
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
    close.addEventListener("click", function () {
      popup.style.display = "none";
    });
  }
}
function fillForm(data) {

  document.getElementById("text-name").value = data.name;
  document.getElementById("text-level").value = data.complexityLevel;
  document.getElementById("text").value = data.content;
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

function wrapWordsInSpans(text) {
  // Розбиваємо текст на окремі слова за допомогою методу split()

  const words = text.split(' ');

  // Створюємо новий масив, який міститиме HTML-елементи для кожного слова
  const wordSpans = words.map(word => `<span class="word">${word} </span>`);

  // Повертаємо рядок, який містить HTML-елементи <span> для кожного слова
  return wordSpans.join('');
}
function wrapTextItem(listNames) {
  const modifiedString = listNames.replace(/\[\"|\"\]/g, '');
  const values = modifiedString.split('","');

  let wordSpans = [];
  let wordSpans2 = [];

  // //console.log(values);
  for (let i = 0; i < values.length; i++) {
    wordSpans[i] = values[i].split(',')[1];
  }
  // //console.log(wordSpans);
  wordSpans2 = wordSpans.map(name => `<li><input type="radio" name="text-item">${name} </li>`);

  return wordSpans2.join('');
}
function getTextId(texts, name) {
  let wordSpans = [];
  wordSpans = getTextsName(texts);
  for (let i = 0; i < wordSpans.length; i++) {
    if (name == wordSpans[i]) {
      console.log(getTextsId(texts)[i]);
      return getTextsId(texts)[i];
    }
  }

}
function getTextsId(texts) {
  const modifiedString = texts.replace(/\[\"|\"\]/g, '');
  const values = modifiedString.split('","');

  let wordSpans = [];
  let wordSpans2 = [];

  // //console.log(values);
  for (let i = 0; i < values.length; i++) {
    wordSpans[i] = values[i].split(',')[0];
  }
  return wordSpans;
}
function getTextsName(texts) {
  const modifiedString = texts.replace(/\[\"|\"\]/g, '');
  const values = modifiedString.split('","');

  let wordSpans = [];
  let wordSpans2 = [];

  // //console.log(values);
  for (let i = 0; i < values.length; i++) {
    wordSpans[i] = values[i].split(',')[1];
  }
  return wordSpans;
}
function getTextName(texts, id) {
  return getTextsName(texts)[id];
}
function getTr() {
  let m_word = word.innerHTML.trim();
  fetch(`${url}${m_word}`)
    .then((response) => response.json())
    .then((data) => {
      //console.log(data);
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
      //console.log(result[2]);
    })
    .catch((error) => console.error(error));

  return result[2];
}