/**
 *  자바스크립트는 동적 타입을 지원하기 때문에 자료형에 대한 명시를
 *  할 필요가 없다.
 */

function f1() {
	return "함수 실행이 완료되었습니다.";
}

function f2() {
	return 100;
}

function f3() {
	return;
}

var f4 = function() {
	return "익명함수 입니다.";
};

(function() {
	console.log("즉시 실행하는 함수 입니다.");
})();

function f5(x) {
	console.log("매개변수 x 값 -> " + x);
}

function f6(x, y=0) {
	console.log("매개변수 x, y 값 -> " + x + ", " + y);
}

function f7(x, ...args) {
	console.log("매개변수 x 값 -> " + x);
	for(let arg of args) {
		console.log("매개변수 args 값 -> " + arg);
	}
}

function f8(x, y=0, ...args) {
	console.log("매개변수 x, y 값 -> " + x + ", " + y);
	for(let arg of args) {
		console.log("매개변수 args 값 -> " + arg);
	}
}

function f9() {
	console.log(arguments);
	for(let v of arguments) {
		console.log(v);
	}
}


















