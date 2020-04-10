package fs.io;

import io.vertx.core.buffer.Buffer;

public final class BufferWriter {

    private final Buffer buffer = Buffer.buffer();

    public BufferWriter clone(BufferWriter writer) {
        buffer.appendBuffer(writer.getBuffer());
        return this;
    }

    private BufferWriter putByte(int b) {
        buffer.appendByte((byte) b);
        return this;
    }

    public BufferWriter put(int value) {
        putByte(value);
        return this;
    }

    public BufferWriter putBytes(byte[] bytes) {
        buffer.appendBytes(bytes);
        return this;
    }

    public BufferWriter putShort(int value, Endian endian) {
        switch (endian) {
            case LITTLE:
                put(value);
                put(value >> 8);
                break;
            case BIG:
                put(value >> 8);
                put(value);
                break;
            default:
                throw new IllegalArgumentException("Unsupported operation");
        }
        return this;
    }

    public BufferWriter putShort(int value) {
        putShort(value, Endian.BIG);
        return this;
    }

    public BufferWriter putInt(int value, Endian endian) {
        switch (endian) {
            case LITTLE:
                put(value);
                put(value >> 8);
                put(value >> 16);
                put(value >> 24);
                break;
            case MIDDLE:
                put(value >> 8);
                put(value);
                put(value >> 24);
                put(value >> 16);
                break;
            case INVERSED_MIDDLE:
                put(value >> 16);
                put(value >> 24);
                put(value);
                put(value >> 8);
                break;
            case BIG:
                put(value >> 24);
                put(value >> 16);
                put(value >> 8);
                put(value);
                break;
        }
        return this;
    }

    public BufferWriter putInt(int value) {
        putInt(value, Endian.BIG);
        return this;
    }

    public BufferWriter putLong(long value) {
        putLong((int) value, Endian.BIG);
        return this;
    }

    public BufferWriter putLong(int value, Endian endian) {
        switch(endian) {
            case LITTLE:
                put(value);
                put(value >> 8);
                put(value >> 16);
                put(value >> 24);
                put(value >> 32);
                put(value >> 40);
                put(value >> 48);
                put(value >> 56);
                break;
            case BIG:
                put(value >> 56);
                put(value >> 48);
                put(value >> 40);
                put(value >> 32);
                put(value >> 24);
                put(value >> 16);
                put(value >> 8);
                put(value);
                break;
            default:
                throw new IllegalArgumentException("Unsupported operation");
        }
        return this;
    }

    public Buffer getBuffer() {
        return buffer;
    }

}