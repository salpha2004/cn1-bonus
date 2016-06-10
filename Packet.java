class Packet {
	int version;
	String srcAddr;
	String dstAddr;
	byte[] data;
	Packet (int version, String src, String dst) {
		this.version = version;
		srcAddr = src;
		dstAddr = dst;
	}
	int getVersion () {
		return version;
	}
	String getSrc () {
		return srcAddr;
	}
	String getDst () {
		return dstAddr;
	}
}
