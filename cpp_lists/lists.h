
#ifdef _MY_LISTS_H_
#define _MY_LISTS_H_

// It helps with integration in other projects
#define LL_NODE_NAME Node
#define LL_HEAD Head

#define LL_E_NO_HEAD 1

typedef 
{
    NODE_NAME* next;
    void* value;

} LL_NODE_NAME;

typedef
{
    NODE_NAME* head;
    unsigned int size;
} LL_HEAD;

int AddLLNode(LL_HEAD* list, void* value);
int RemoveLLNode(LL_HEAD* list, LL_NODE_NAME* node);

#endif // _MY_LISTS_H_
