class Packet {
	// TODO: subnet mask was assumed to be 24 for all ipv4 packets
	// and 64 for all ipv6 packets and omitted for simplicity. -> change getDstMasked if changed your thought.
	int version;
	String srcAddr;
	String dstAddr;
	byte[] data;
	Packet (int version, String src, String dst) {
		this.version = version;
		srcAddr = src;
		dstAddr = dst;
	}
	Packet (Packet p) {
		version = p.getVersion();
		srcAddr = p.getSrc();
		dstAddr = p.getDst();
	}
	void setSrc (String src) {
		srcAddr = src;
	}
	void setData (byte[] newData) {
		data = newData;
	}
	void setVersionTo4 () {
		version = 4;
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
	/* returns the address combined with subnet mask (denoted as 'X'). */
	String getDstMasked () {
		int i = 0;
		String maskedDstAddr = new String();
		if (version == 4) {
			maskedDstAddr = dstAddr.substring (0, dstAddr.lastIndexOf ('.'));
			maskedDstAddr += ".X";
		}		
		if (version == 6) {
			String[] addrParts = dstAddr.split (":");
			for (String part : addrParts) {
				if (i < 4)
					maskedDstAddr += (part + ":");
				else
					/* avoid colon after the last X. */
					if (i != addrParts.length - 1)
						maskedDstAddr += "X:";
					else
						maskedDstAddr += "X";
				i++;
			}
		}
		return maskedDstAddr;
	}

}
