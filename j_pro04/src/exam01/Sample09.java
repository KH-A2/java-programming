package exam01;

import java.util.Arrays;

public class Sample09 {

	public static void main(String[] args) {
		/*
		 * 동적 배열
		 * 		- 기존의 배열은 크기가 한 번 정해지면 크기를 늘리거나 줄일 수 없다.
		 * 		- 원본 배열의 크기를 늘리거나 줄일 수 있도록 조작.(실제로 늘리는건 아님)
		 * 		- 최초 배열의 크기보다 크거나 작은 배열을 새로 만들고 새로 생성된 배열에 값을 복사하는 형식으로 작업.
		 */
		int[] arr1 = new int[3];
		arr1[0] = 10;	arr1[1] = 20;	arr1[2] = 30;
		
		System.out.println(Arrays.toString(arr1));
		
		int[] temp = new int[arr1.length + 1];
		for(int i = 0; i < arr1.length; i++) {
			temp[i] = arr1[i];
		}
		arr1 = temp;
		System.out.println(Arrays.toString(arr1));
		
		temp = Arrays.copyOf(arr1, arr1.length + 1);
		arr1 = temp;
		System.out.println(Arrays.toString(arr1));
		
		temp = new int[arr1.length + 1];
		System.arraycopy(arr1, 0, temp, 0, arr1.length);
		arr1 = temp;
		System.out.println(Arrays.toString(arr1));
		
		temp = new int[arr1.length + 1];
		System.arraycopy(arr1, 0, temp, 1, arr1.length);
		arr1 = temp;
		System.out.println(Arrays.toString(arr1));
	}

}
