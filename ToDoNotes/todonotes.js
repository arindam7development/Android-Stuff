

window.onload = init;

function init() {
	var button = document.getElementById("add_button");
	button.onclick = createSticky;

	var clearButton = document.getElementById("clear_button");
	clearButton.onclick = clearStickyNotes;


	var stickiesArray = getStickiesArray();
	
	for (var i = 0; i < stickiesArray.length; i++) {
		var key = stickiesArray[i];
		var value = JSON.parse(localStorage[key]);
		addStickyToDOM(key, value);
	}	
}
function getStickiesArray() {
	var stickiesArray = localStorage.getItem("stickiesArray");
	if (!stickiesArray) {
		stickiesArray = [];
		localStorage.setItem("stickiesArray", JSON.stringify(stickiesArray));
	} else {
		stickiesArray = JSON.parse(stickiesArray);
	}
	return stickiesArray;
}

function createSticky() {
	var stickiesArray = getStickiesArray();
	var value = document.getElementById("note_text").value;
	var colorSelectObj = document.getElementById("note_color");
	var index = colorSelectObj.selectedIndex;
	var color = colorSelectObj[index].value;

	// create sticky note using JSON 
	var currentDate = new Date();
	var key = "sticky_" + currentDate.getTime();
	var stickyObj = {
			"value": value,
			"color": color
	};
	localStorage.setItem(key, JSON.stringify(stickyObj));

	// add new sticky note key to array 
	stickiesArray.push(key);
	localStorage.setItem("stickiesArray", JSON.stringify(stickiesArray));
	
	addStickyToDOM(key, stickyObj);
}

function deleteSticky(e) {
	var key = e.target.id;
	if (e.target.tagName.toLowerCase() == "span") {
		key = e.target.parentNode.id;
	}
	var stickiesArray = getStickiesArray();
	if (stickiesArray) {
		for (var i = 0; i < stickiesArray.length; i++) {
			if (key == stickiesArray[i]) {
				stickiesArray.splice(i,1);
			}
		}
		localStorage.removeItem(key);
		localStorage.setItem("stickiesArray", JSON.stringify(stickiesArray));
		removeStickyFromDOM(key);
	}
}

function addStickyToDOM(key, stickyObj) {
	var stickies = document.getElementById("stickies");

	var sticky = document.createElement("li");
	
	sticky.setAttribute("id", key);

	sticky.style.backgroundColor = stickyObj.color;

	var span = document.createElement("span");
	span.setAttribute("class", "sticky");

 
	span.innerHTML = stickyObj.value;


	sticky.appendChild(span);
	stickies.appendChild(sticky);

	
	sticky.onclick = deleteSticky;
}

function removeStickyFromDOM(key) {
	var sticky = document.getElementById(key);
	sticky.parentNode.removeChild(sticky);
}

function clearStickyNotes() {
	localStorage.clear();
	var stickyList = document.getElementById("stickies");
	var stickies = stickyList.childNodes;
	for (var i = stickies.length-1; i >= 0; i--) {
		stickyList.removeChild(stickies[i]);
	}

	
	var stickiesArray = getStickiesArray();
}

