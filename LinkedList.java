/*structure of a node of the linked list is as
struct Node
{
	int data;
	struct Node* next;
	
	Node(int x){
	    data = x;
	    next = NULL;
	}
	
};

*/
// Function should return 0 is length is even else return 1
int isLengthEvenOrOdd(struct Node* head)
{
     int cont = 0;
     
     while(head != NULL){
         cont++;
         head = head->next;
     }
     
     if(cont % 2 == 0){
         return 0;
     }else{
         return 1;
     }
}
