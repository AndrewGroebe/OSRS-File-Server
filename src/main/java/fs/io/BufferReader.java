package fs.io;

import io.vertx.core.buffer.Buffer;

/**
 * A class that encapsulates {@link Buffer} and provides additional functionality for reading bytes from a buffer.
 *
 * @author Andys1814
 */
public final class BufferReader {

    private final Buffer buffer = Buffer.buffer();
    private int position;

    public BufferReader(byte[] bytes) {
        buffer.appendBytes(bytes);
    }

    public int getSignedByte() {
        return buffer.getByte(position++);
    }

    public int getUnsignedByte() {
        return buffer.getUnsignedByte(position++) & 0xFF;
    }

    public int getSignedShort() {
        return getSignedShort(Endian.BIG);
    }

    public int getUnsignedShort() {
        return getUnsignedShort(Endian.BIG);
    }

    public int getSignedInt() {
        return getSignedInt(Endian.BIG);
    }

    public int getUnsignedInt() {
        return getUnsignedInt(Endian.BIG);
    }

    public int getLong() {
        return getUnsignedLong(Endian.BIG);
    }

    public int getUnsignedShort(Endian endian) {
        return endianShort(endian) & 0xFFFF;
    }

    public int getSignedShort(Endian endian) {
        return endianShort(endian);
    }

    private int endianShort(Endian endian) {
        int value = 0;

        switch (endian) {
            case LITTLE:
                value |= getUnsignedByte();
                value |= getUnsignedByte() << 8;
                break;
            case BIG:
                value |= getUnsignedByte() << 8;
                value |= getUnsignedByte();
                break;
            default:
                throw new UnsupportedOperationException("Operation unsupported");
        }

        return value;
    }

    public int getUnsignedInt(Endian endian) {
        long value = 0;
        switch (endian) {
            case LITTLE:
                value |= getUnsignedByte();
                value |= getUnsignedByte() << 8;
                value |= getUnsignedByte() << 16;
                value |= getUnsignedByte() << 24;
                break;
            case MIDDLE:
                value |= getUnsignedByte() << 8;
                value |= getUnsignedByte();
                value |= getUnsignedByte() << 24;
                value |= getUnsignedByte() << 16;
                break;
            case INVERSED_MIDDLE:
                value |= getUnsignedByte() << 16;
                value |= getUnsignedByte() << 24;
                value |= getUnsignedByte();
                value |= getUnsignedByte() << 8;
                break;
            case BIG:
                value |= getUnsignedByte() << 24;
                value |= getUnsignedByte() << 16;
                value |= getUnsignedByte() << 8;
                value |= getUnsignedByte();
                break;
        }
        return (int) value;
    }

    public int getSignedInt(Endian endian) {
        return (int) (getUnsignedInt(endian) & 0xFFFFFFFFL);
    }

    public long getL() {
        long value = buffer.getLong(position);
        position += 8;
        return value;
    }

    public int getUnsignedLong(Endian endian) {
        int value = 0;
        switch (endian) {
            case BIG:
                value |= getUnsignedByte() << 56;
                value |= getUnsignedByte() << 48;
                value |= getUnsignedByte() << 40;
                value |= getUnsignedByte() << 32;
                value |= getUnsignedByte() << 24;
                value |= getUnsignedByte() << 16;
                value |= getUnsignedByte() << 8;
                value |= getUnsignedByte();
                break;
            case LITTLE:
                value |= getUnsignedByte();
                value |= getUnsignedByte() << 8;
                value |= getUnsignedByte() << 16;
                value |= getUnsignedByte() << 24;
                value |= getUnsignedByte() << 32;
                value |= getUnsignedByte() << 40;
                value |= getUnsignedByte() << 48;
                value |= getUnsignedByte() << 56;
                break;
            default:
                throw new UnsupportedOperationException("Unsupported operation");
        }
        return value;
    }

    public int readBigSmart() {
        if (buffer.getBytes()[position] >= 0) {
            return getUnsignedShort();
        }
        return getUnsignedInt() & 0x7fffffff;
    }

    public byte[] getBytes(int amount) {
        byte[] data = new byte[amount];
        for (int i = 0; i < amount; i++) {
            data[i] = (byte) getUnsignedByte();
        }
        return data;
    }

    public void getBytes(byte[] bytes, int offset, int length) {
        for (int i = offset; i < offset + length; i++) {
            bytes[i] = (byte) getUnsignedByte();
        }
    }

    public void putInt(int value) {
        buffer.setByte(position++, (byte) (value >> 24));
        buffer.setByte(position++, (byte) (value >> 16));
        buffer.setByte(position++, (byte) (value >> 8));
        buffer.setByte(position++, (byte) value);
    }

    public void getBytes(byte[] bytes) {
        getBytes(bytes, 0, bytes.length);
    }

    public void skipBytes(int amount) {
        getBytes(amount);
    }

    public int getLength() {
        return buffer.length();
    }

    public int position() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int remaining() {
        return buffer.length() - position;
    }

    public byte[] getBytes() {
        return buffer.getBytes();
    }

    public Buffer getBuffer() {
        return buffer;
    }

}
