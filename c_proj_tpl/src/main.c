#include <stdio.h>

int main(int argc, char* argv[])
{
    printf("program: '%s' argc = '%d'\n", argv[0], argc);
    int i = 0;
    for ( ; i < argc; i++)
    {
        printf("argv[%d] = '%s'\n", i, argv[i]);
    }
    printf("Hello World\n");
    return 0;
}
