class Packet {
	// TODO: subnet mask was assumed to be 24 for all packets and omitted for simplicity. -> change getDstMasked if changed your thought.
	// TODO: how is subnet mask implemented for ipv6?
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
	String getDstMasked () {
		String maskedDstAddr = dstAddr.substring (0, dstAddr.lastIndexOf ('.'));
		maskedDstAddr += ".X";
		return maskedDstAddr;
	}
}
