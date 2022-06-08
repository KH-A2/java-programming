/**
 * 
 */

// var arr1 = [1, 2, 3];
var arr1 = new Array(1, 2, 3);
var res1 = document.getElementById("res1");
res1.innerHTML += arr1 + "<br>";
res1.innerHTML += "arr1[0] -> " + arr1[0] + "<br>";
res1.innerHTML += "arr1[1] -> " + arr1[1] + "<br>";
res1.innerHTML += "arr1[2] -> " + arr1[2] + "<br>";

arr1[0] = 10;
arr1[1] = 20;
arr1[2] = 30;
res1.innerHTML += arr1 + "<br>";

res1.innerHTML += "arr1.indexOf(10) -> " + arr1.indexOf(10) + "<br>";
res1.innerHTML += "arr1.indexOf(20) -> " + arr1.indexOf(20) + "<br>";
res1.innerHTML += "arr1.indexOf(30) -> " + arr1.indexOf(30) + "<br>";

res1.innerHTML += "arr1.push(40)" + "<br>";
arr1.push(40);
res1.innerHTML += "arr1.push(50)" + "<br>";
arr1.push(50);
res1.innerHTML += "arr1.push(60)" + "<br>";
arr1.push(60);
res1.innerHTML += arr1 + "<br>";

res1.innerHTML += "arr1.unshift(0)" + "<br>";
arr1.unshift(0);
res1.innerHTML += arr1 + "<br>";

res1.innerHTML += "arr1.pop()" + "<br>";
arr1.pop();
res1.innerHTML += arr1 + "<br>";

res1.innerHTML += "arr1.shift()" + "<br>";
arr1.shift();
res1.innerHTML += arr1 + "<br>";


/**
 *  input 요소에 있는 값을 배열로 만들어 exam1 에 출력
 *  출력 형식은 ['a', 'b', 'c', 'd', 'e'] 와 같이
 *  대괄호 안에 값을 출력
 */
var arr2;
var input1 = document.getElementById("id_input1");
var exam1 = document.getElementById("exam1");
arr2 = input1.value.split(",");

for(var i = 0; i < arr2.length; i++) {
	arr2[i] = arr2[i].trim();
}

exam1.innerHTML = "['" + arr2.join("', '") + "']";

/**
 *  input 요소에 있는 값을 앞서 만든 배열에 추가 후 출력
 *  출력 형식은 기존과 동일
 *  추가로 input 요소에 있는 값의 총 합을 구하여 배열에 추가 한다.
 */
var input2 = document.getElementById("id_input2");
var exam2 = document.getElementById("exam2");
var tmp = input2.value.split(",");
var total = 0;

for(let item of tmp) {
	item = parseInt(item);
	total += item;
	arr2.push(item);
}
arr2.push(total);

exam2.innerHTML = "['" + arr2.join("', '") + "']";









