
PROJECT=test
CFLAGS=-c -W -Wall -g

CC=g++
DEL=rm -rf
MKDIR=mkdir -p

LINK_FLAGS=-g
OUTPUT=-o

OBJ_DIR=obj

OBJECTS=\
		$(OBJ_DIR)/main.o \
		$(OBJ_DIR)/hexdump.o \
		$(OBJ_DIR)/hexdump_tests.o \
	
.PHONY: dir_structure

.PHONY: all

all: dir_structure $(PROJECT)

dir_structure: $(OBJ_DIR)

$(OBJ_DIR):
	$(MKDIR) $(OBJ_DIR)

$(PROJECT): $(OBJECTS)
	$(CC) $(LINK_FLAGS) $(OBJECTS) $(OUTPUT) $(PROJECT)

$(OBJ_DIR)/main.o: main.cpp
	$(CC) $(CFLAGS) main.cpp $(OUTPUT) $(OBJ_DIR)/main.o

$(OBJ_DIR)/hexdump.o: hexdump.cpp hexdump.h
	$(CC) $(CFLAGS) hexdump.cpp $(OUTPUT) $(OBJ_DIR)/hexdump.o

$(OBJ_DIR)/hexdump_tests.o: hexdump_tests.cpp hexdump_tests.h hexdump.h
	$(CC) $(CFLAGS) hexdump_tests.cpp $(OUTPUT) $(OBJ_DIR)/hexdump_tests.o

clean:
	$(DEL) $(OBJ_DIR)
	$(DEL) $(PROJECT)

