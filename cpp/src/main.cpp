#include <stdio.h>
#include <string.h>

#include "hexdump.h"
#include "hexdump_tests.h"

int main(int argc, char* argv[])
{
    bool verbose = false;
    int global_suites_to_run = 0;
    int global_suites_passed = 0;

    // Check to see if we need to be verbose or not
    for (int i = 0; i < argc; i++)
    {
        if ((strcmp(argv[i], "--verbose") == 0) ||
            (strcmp(argv[i], "-v") == 0))
        {
            verbose = true;
        }
    }

    // Run the tests
    for (int i = 0; i < argc; i++)
    {
        if (strcmp(argv[i], "--hexdump") == 0)
        {
            if (hexdump_tests_main(verbose))
            {
                global_suites_passed++;
            }
            global_suites_to_run++;
        }
    }

    // Show the status
    if (global_suites_to_run > 0)
    {
        printf("Run %d tests suites of which %d passed. Global passrate is %0.2f\n",
                global_suites_to_run,
                global_suites_passed,
                (float) global_suites_passed / (float) global_suites_to_run);
    }
    else
    {
        printf("No suites to run\n");
    }
    return 0;
}
