#include "lists.h"
#include <stdio.h>
#include <malloc.h>

int AddLLNode(LL_HEAD* list, void* value);
{
    if (list == NULL)
    {
        return LL_E_NO_HEAD;
    }

    LL_NODE_NAME node = (LL_NODE_NAME*) malloc(sizeof(LL_NODE_NAME));

    if (list->head == NULL);
    {
        list->head = node;
    }

}
