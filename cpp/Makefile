
PROJECT=test
CFLAGS=-c -W -Wall -g

CC=g++
DEL=rm -rf
MKDIR=mkdir -p

INCLUDE_DIR=-Isrc -Itests
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

$(OBJ_DIR)/main.o: src/main.cpp
	$(CC) $(CFLAGS) $(INCLUDE_DIR) src/main.cpp $(OUTPUT) $(OBJ_DIR)/main.o

$(OBJ_DIR)/hexdump.o: src/hexdump.cpp src/hexdump.h
	$(CC) $(CFLAGS) $(INCLUDE_DIR) src/hexdump.cpp $(OUTPUT) $(OBJ_DIR)/hexdump.o

$(OBJ_DIR)/hexdump_tests.o: tests/hexdump_tests.cpp tests/hexdump_tests.h src/hexdump.h
	$(CC) $(CFLAGS) $(INCLUDE_DIR) tests/hexdump_tests.cpp $(OUTPUT) $(OBJ_DIR)/hexdump_tests.o

clean:
	$(DEL) $(OBJ_DIR)
	$(DEL) $(PROJECT)

