#include <stdio.h>

int count_digits(int A){
	int num_digits = 0;
	if(A == 0){
		return 1;
	}
	
	int copy = A;
	
	while(copy > 0){
		copy = copy / 10;
		num_digits += 1;
	}
	return num_digits;
}

int calculate_pf(int A){
	int num_digits = count_digits(A);
	int pf = 0;
	
	if(num_digits == 3){
		pf = 495;
	}else if(num_digits == 4 ){
		pf = 6174;
	}
	return pf;
}
void build_arrayA(int A, int arr[], int len){
	int copy = A;
	int pf = calculate_pf(A);
	
	if(pf == 6174 && len < 4){
		arr[0] = 0;
		int i = 1;
		while(copy > 0){
			int digit = copy % 10; // extracts the digits
			i += 1;
			arr[i] = digit;
			copy = copy / 10;
		}
	}else{
		int i = 0;
		while(copy > 0){
			int digit = copy % 10; // extracts the digits
			arr[i] = digit;
			copy = copy / 10;
			i += 1;
		}
	}
	
}

void build_arrayC(int arr[], int len){
	
	for(int i = 0; i < len; i++){
		for(int j = 0; j < len-i-1; j++){
			if(arr[j] > arr[j+1]){
				int temp = arr[j];
				arr[j] = arr[j+1];
				arr[j+1] = temp;
			}
		}
	}
}

void build_arrayB(int arr[], int len){
	
	for(int i = 0; i < len; i++){
		for(int j = 0; j < len-i-1; j++){
			if(arr[j] < arr[j+1]){
				int temp = arr[j];
				arr[j] = arr[j+1];
				arr[j+1] = temp;
			}
		}
	}
}


	
int calculate_difference(int b, int c){
	return b - c;
}

void numeric_sequence(int A){
	int num_digits = count_digits(A);
	int pf = calculate_pf(A);
	int arr[num_digits];
	int count = 1;
	

	printf("%d", A);
	while(A != pf && A != 0){
		build_arrayA(A,arr,num_digits);

		build_arrayC(arr, num_digits);
		int C = 0;
		
		for(int i = 0; i < num_digits; i++){
			C = C*10 + arr[i];
		}
		build_arrayB(arr, num_digits);
		int B = 0;
		for(int i = 0; i < num_digits; i++){
			B = B*10 + arr[i];
		}
		 A = calculate_difference(B, C);

        int new_digits = count_digits(A);
        if (new_digits < num_digits) {
            A *= 10;  
        }

        num_digits = count_digits(A);
        
        pf = calculate_pf(A);
        
        count += 1;
        printf(",%d", A);  
	}
	
	printf( "    %d\n", count);
	
	
}
 
int main(){
	FILE *pf = fopen("D:\\sequence\\entrada.txt", "r");
	
	if(pf == NULL){
		printf("Erro ao abrir arquivo");
		return -1;
	}
	int num_input = 0;
	fscanf(pf,"%d", &num_input);
	
	for(int i = 0 ; i < num_input; i++){
		int A;
		fscanf(pf, "%d", &A);
		numeric_sequence(A);
	}
	
	fclose(pf);
	

//	int A = 195;
//	numeric_sequence(A);
	return 0;

}	