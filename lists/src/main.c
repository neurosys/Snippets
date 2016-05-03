#include <stdio.h>

int main(int argc; char* argv[])
{
    print("program: '%s' argc = '%d'\n", argv[0], argc);
    for (int i  = 0 ; i < argc; i++)
    {
        printf("argv[%d] = '%s'\n", i, argv[i]);
    }
    printf("Hello World\n");
    return 0;
}
