/**
 * 
 */

window.onload = function() {
	let month_selects = document.querySelectorAll("select.sel-month");
	
	for(e of month_selects) {
		createOptionMonth(e);
	}
};

function createOptionMonth(element) {
	for(let i = 1; i <= 12; i++) {
		let option = document.createElement("option");
		option.setAttribute("value", i);
		option.innerText = `${i}월`;
		element.append(option);
	}
}

function createOptionDate(e1, e2) {
	let month = e1.value;
	let date = new Date();
	date.setMonth(month, 0);
	
	let count = e2.childElementCount;
	if(count > 1) {
		let opts = e2.children;
		for(let idx = 1; idx < count; idx++) {
			e2.removeChild(opts[1]);
		}
	}
	
	for(let d = 1; d <= date.getDate(); d++) {
		let option = document.createElement("option");
		option.setAttribute("value", d);
		option.innerText = `${d}일`;
		e2.append(option);
	}
}

function toggleAll(element) {
	let name = element.getAttribute("name");
	let chk_items = document.getElementsByName(name);
	
	if(element.getAttribute("checked") === "") {
		for(e of chk_items) {
			e.removeAttribute("checked");
		}	
	} else {
		for(e of chk_items) {
			e.setAttribute("checked", "");
		}
	}
}

function prevMenu() {
	var sliderMenu = document.getElementsByClassName("slide-menu")[0];
	var sliderItems = sliderMenu.children;
	var activeIdx;
	
	for(let idx = 0; idx < sliderItems.length; idx++) {
		let classname = sliderItems[idx].getAttribute("class");
		if(classname.indexOf("active") != -1) {
			sliderItems[idx].setAttribute("class", "slide-item");
			activeIdx = idx - 1;
			break;
		}
	}
	sliderItems[activeIdx].setAttribute("class", "slide-item active");
}

function nextMenu() {
	var sliderMenu = document.getElementsByClassName("slide-menu")[0];
	var sliderItems = sliderMenu.children;
	var activeIdx;
	
	for(let idx = 0; idx < sliderItems.length; idx++) {
		let classname = sliderItems[idx].getAttribute("class");
		if(classname.indexOf("active") != -1) {
			sliderItems[idx].setAttribute("class", "slide-item");
			activeIdx = idx + 1;
			break;
		}
	}
	sliderItems[activeIdx].setAttribute("class", "slide-item active");
}

















