/**
 * This class is automatically generated by mig. DO NOT EDIT THIS FILE.
 * This class implements a Java interface to the 'DissMsg'
 * message type.
 */

package parserxmlnew;

public class DissMsg extends net.tinyos.message.Message {

    /** The default size of this message type in bytes. */
    public static final int DEFAULT_MESSAGE_SIZE = 5;

    /** The Active Message type associated with this message. */
    public static final int AM_TYPE = 113;

    /** Create a new DissMsg of size 5. */
    public DissMsg() {
        super(DEFAULT_MESSAGE_SIZE);
        amTypeSet(AM_TYPE);
    }

    /** Create a new DissMsg of the given data_length. */
    public DissMsg(int data_length) {
        super(data_length);
        amTypeSet(AM_TYPE);
    }

    /**
     * Create a new DissMsg with the given data_length
     * and base offset.
     */
    public DissMsg(int data_length, int base_offset) {
        super(data_length, base_offset);
        amTypeSet(AM_TYPE);
    }

    /**
     * Create a new DissMsg using the given byte array
     * as backing store.
     */
    public DissMsg(byte[] data) {
        super(data);
        amTypeSet(AM_TYPE);
    }

    /**
     * Create a new DissMsg using the given byte array
     * as backing store, with the given base offset.
     */
    public DissMsg(byte[] data, int base_offset) {
        super(data, base_offset);
        amTypeSet(AM_TYPE);
    }

    /**
     * Create a new DissMsg using the given byte array
     * as backing store, with the given base offset and data length.
     */
    public DissMsg(byte[] data, int base_offset, int data_length) {
        super(data, base_offset, data_length);
        amTypeSet(AM_TYPE);
    }

    /**
     * Create a new DissMsg embedded in the given message
     * at the given base offset.
     */
    public DissMsg(net.tinyos.message.Message msg, int base_offset) {
        super(msg, base_offset, DEFAULT_MESSAGE_SIZE);
        amTypeSet(AM_TYPE);
    }

    /**
     * Create a new DissMsg embedded in the given message
     * at the given base offset and length.
     */
    public DissMsg(net.tinyos.message.Message msg, int base_offset, int data_length) {
        super(msg, base_offset, data_length);
        amTypeSet(AM_TYPE);
    }

    /**
    /* Return a String representation of this message. Includes the
     * message type name and the non-indexed field values.
     */
    public String toString() {
      String s = "Message <DissMsg> \n";
      try {
        s += "  [targetid=0x"+Long.toHexString(get_targetid())+"]\n";
      } catch (ArrayIndexOutOfBoundsException aioobe) { /* Skip field */ }
      try {
        s += "  [request=0x"+Long.toHexString(get_request())+"]\n";
      } catch (ArrayIndexOutOfBoundsException aioobe) { /* Skip field */ }
      try {
        s += "  [parameter=0x"+Long.toHexString(get_parameter())+"]\n";
      } catch (ArrayIndexOutOfBoundsException aioobe) { /* Skip field */ }
      return s;
    }

    // Message-type-specific access methods appear below.

    /////////////////////////////////////////////////////////
    // Accessor methods for field: targetid
    //   Field type: int, unsigned
    //   Offset (bits): 0
    //   Size (bits): 16
    /////////////////////////////////////////////////////////

    /**
     * Return whether the field 'targetid' is signed (false).
     */
    public static boolean isSigned_targetid() {
        return false;
    }

    /**
     * Return whether the field 'targetid' is an array (false).
     */
    public static boolean isArray_targetid() {
        return false;
    }

    /**
     * Return the offset (in bytes) of the field 'targetid'
     */
    public static int offset_targetid() {
        return (0 / 8);
    }

    /**
     * Return the offset (in bits) of the field 'targetid'
     */
    public static int offsetBits_targetid() {
        return 0;
    }

    /**
     * Return the value (as a int) of the field 'targetid'
     */
    public int get_targetid() {
        return (int)getUIntBEElement(offsetBits_targetid(), 16);
    }

    /**
     * Set the value of the field 'targetid'
     */
    public void set_targetid(int value) {
        setUIntBEElement(offsetBits_targetid(), 16, value);
    }

    /**
     * Return the size, in bytes, of the field 'targetid'
     */
    public static int size_targetid() {
        return (16 / 8);
    }

    /**
     * Return the size, in bits, of the field 'targetid'
     */
    public static int sizeBits_targetid() {
        return 16;
    }

    /////////////////////////////////////////////////////////
    // Accessor methods for field: request
    //   Field type: short, unsigned
    //   Offset (bits): 16
    //   Size (bits): 8
    /////////////////////////////////////////////////////////

    /**
     * Return whether the field 'request' is signed (false).
     */
    public static boolean isSigned_request() {
        return false;
    }

    /**
     * Return whether the field 'request' is an array (false).
     */
    public static boolean isArray_request() {
        return false;
    }

    /**
     * Return the offset (in bytes) of the field 'request'
     */
    public static int offset_request() {
        return (16 / 8);
    }

    /**
     * Return the offset (in bits) of the field 'request'
     */
    public static int offsetBits_request() {
        return 16;
    }

    /**
     * Return the value (as a short) of the field 'request'
     */
    public short get_request() {
        return (short)getUIntBEElement(offsetBits_request(), 8);
    }

    /**
     * Set the value of the field 'request'
     */
    public void set_request(short value) {
        setUIntBEElement(offsetBits_request(), 8, value);
    }

    /**
     * Return the size, in bytes, of the field 'request'
     */
    public static int size_request() {
        return (8 / 8);
    }

    /**
     * Return the size, in bits, of the field 'request'
     */
    public static int sizeBits_request() {
        return 8;
    }

    /////////////////////////////////////////////////////////
    // Accessor methods for field: parameter
    //   Field type: int, unsigned
    //   Offset (bits): 24
    //   Size (bits): 16
    /////////////////////////////////////////////////////////

    /**
     * Return whether the field 'parameter' is signed (false).
     */
    public static boolean isSigned_parameter() {
        return false;
    }

    /**
     * Return whether the field 'parameter' is an array (false).
     */
    public static boolean isArray_parameter() {
        return false;
    }

    /**
     * Return the offset (in bytes) of the field 'parameter'
     */
    public static int offset_parameter() {
        return (24 / 8);
    }

    /**
     * Return the offset (in bits) of the field 'parameter'
     */
    public static int offsetBits_parameter() {
        return 24;
    }

    /**
     * Return the value (as a int) of the field 'parameter'
     */
    public int get_parameter() {
        return (int)getUIntBEElement(offsetBits_parameter(), 16);
    }

    /**
     * Set the value of the field 'parameter'
     */
    public void set_parameter(int value) {
        setUIntBEElement(offsetBits_parameter(), 16, value);
    }

    /**
     * Return the size, in bytes, of the field 'parameter'
     */
    public static int size_parameter() {
        return (16 / 8);
    }

    /**
     * Return the size, in bits, of the field 'parameter'
     */
    public static int sizeBits_parameter() {
        return 16;
    }

}