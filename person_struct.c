#include <stdio.h>

struct Owner{
	char * petsName;
	char * address;
	char * phone;
};

typedef struct{
	char * ownersName;
	char * breed;
	char * color;
	char * favToy;
} Dog;

int main()
{
	struct Owner kat;
	kat.petsName = "Tanny";
	kat.address = "Albany, NY";
	kat.phone = "5183222929";
	printf( "\n\n Pet's Name: %s\n Address: %s\n Phone#: (%.*s) %.*s - %.*s\n\n", kat.petsName, kat.address, 3, kat.phone, 3, kat.phone + 3, 4, kat.phone + 6);


	Dog tanny;	/* using typedef, you don't need to declare instances with keyword "struct" */
	tanny.ownersName = "Kat";
	tanny.breed = "Biiiiichon";
	tanny.color = "white";
	tanny.favToy = "Wholly the Lamb";
	printf( " Owner's Name: %s\n Breed: %s\n Color %s\n Fav Toy: %s\n\n", tanny.ownersName, tanny.breed, tanny.color, tanny.favToy );

return 0;
}