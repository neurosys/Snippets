#include <stdio.h>

#include "hexdump.h"
#include "hexdump_tests.h"

/*
 
   - Top of the table is length is formed of '-' and it contains '+'-es at the
        intersection with other borders
    - Lines of the table allways start with '|' and have two horizontal spaces 
        between any margin and the actual content (each direction)
    - Hex values are allways represented as 2digit values, with Hex characters ABCDEF
        showed in upercase
    - Between each pair of hex digits, there is a space
    - The ASCII representation section, uses dots '.' to represent values that are out
        of the ASCII range, nonprintable or whitespace
+==========================================================+===================================+
|          1  2  3  4  5  6  7  8  9 10 11 12 13 14 15 16  | size  256  Start Addr 0x12345678  |
+----------------------------------------------------------+-----------------------------------+
|  0000:  00 01 02 03 04 05 06 07 08 09 0A 0B 0C 0D 0E 0F  |  . . . . . . . . . . . . . . . .  |
|  0010:  10 11 12 13 14 15 16 17 18 19 1A 1B 1C 1D 1E 1F  |  . . . . . . . . . . . . . . . .  |
|  0020:  20 21 22 23 24 25 26 27 28 29 2A 2B 2C 2D 2E 2F  |  . ! " # $ % & ' ( ) * + , - . /  |
|  0030:  30 31 32 33 34 35 36 37 38 39 3A 3B 3C 3D 3E 3F  |  0 1 2 3 4 5 6 7 8 9 : ; < = > ?  |
|  0040:  40 41 42 43 44 45 46 47 48 49 4A 4B 4C 4D 4E 4F  |  @ A B C D E F G H I J K L M N O  |
|  0050:  50 51 52 53 54 55 56 57 58 59 5A 5B 5C 5D 5E 5F  |  P Q R S T U V W X Y Z [ \ ] ^ _  |
|  0060:  60 61 62 63 64 65 66 67 68 69 6A 6B 6C 6D 6E 6F  |  ` a b c d e f g h i j k l m n o  |
|  0070:  70 71 72 73 74 75 76 77 78 79 7A 7B 7C 7D 7E 7F  |  p q r s t u v w x y z { | } ~ .  |
|  0080:  80 81 82 83 84 85 86 87 88 89 8A 8B 8C 8D 8E 8F  |  . . . . . . . . . . . . . . . .  |
|  0090:  90 91 92 93 94 95 96 97 98 99 9A 9B 9C 9D 9E 9F  |  . . . . . . . . . . . . . . . .  |
|  00A0:  A0 A1 A2 A3 A4 A5 A6 A7 A8 A9 AA AB AC AD AE AF  |  . . . . . . . . . . . . . . . .  |
|  00B0:  B0 B1 B2 B3 B4 B5 B6 B7 B8 B9 BA BB BC BD BE BF  |  . . . . . . . . . . . . . . . .  |
|  00C0:  C0 C1 C2 C3 C4 C5 C6 C7 C8 C9 CA CB CC CD CE CF  |  . . . . . . . . . . . . . . . .  |
|  00D0:  D0 D1 D2 D3 D4 D5 D6 D7 D8 D9 DA DB DC DD DE DF  |  . . . . . . . . . . . . . . . .  |
|  00E0:  E0 E1 E2 E3 E4 E5 E6 E7 E8 E9 EA EB EC ED EE EF  |  . . . . . . . . . . . . . . . .  |
|  00F0:  F0 F1 F2 F3 F4 F5 F6 F7 F8 F9 FA FB FC FD FE FF  |  . . . . . . . . . . . . . . . .  |
+==========================================================+===================================+
*/


bool test_standard_formatting(bool verbose)
{
    // The lines have the correct width
    return false;
}

bool test_configurable_formatting(bool verbose)
{
    // You can configure the width, and the result is accordingly
    return false;
}

bool test_nr_of_columns(bool verbose)
{
    // the number of columns displayed in the buffers is correct
    return false;
}

bool test_hex_values(bool verbose)
{
    // values displayed in hex are the correct ones
    return false;
}

bool test_ascii_representation(bool verbose)
{
    // the ascii values displayed are representative and correct
    return false;
}

bool hexdump_tests_main(bool verbose)
{
    bool rez = false;
    printf("hexdump_tests_main() = %s\n", (rez) ? "[Passed]" : "[FAILED]"); 
    return false;
}
