#include <stdio.h>
#include <stdint.h>

// copy the contents of one binary file to another

// an unsigned 8-bit integer
typedef uint8_t BYTE;

int main(int argc, char *argv[])
{
    FILE *src = fopen(argv[1], "rb");
    FILE *dst = fopen(argv[2], "wb");

    BYTE b;

    // A single byte (8 bits) is read from the source file into the variable b using fread. The size of b is 1 byte (sizeof(b))
    // fread returns the number of elements successfully read, which is 1 in this case. 
    // The loop continues until fread returns 0, meaning no more data is left to read.
    // fwrite then writes the byte from b to the destination file.
    while (fread(&b, siceof(b), 1, src) != 0) {
        fwrite(&b,sizeof(b), 1, dst);
    }

    fclose(dst);
    fclose(src);
}