package tmData;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class KNP {

    public final ArrayList<TmDat> list = new ArrayList<>();

    public void run(String inNameF) throws IOException {
        FileInputStream fin = new FileInputStream(inNameF);
        byte[] buf = new byte[16];
        fin.skip(32);

        while ((fin.read(buf, 0, 16)) > 0) {
            TmDat tmDat = new TmDat();
            tmDat.num = (buf[0] << 8)&0xFF00 | (buf[1]&0xFF);
            tmDat.time = java.nio.ByteBuffer.wrap(new byte[]{0,0,0,0,buf[2],buf[3],buf[4],buf[5]}).getLong();
            //tmDat.time = (buf[2] << 24)&0xFF000000 | (buf[3]<<16)&0xFF0000 | (buf[4]<<8)&0xFF00 | (buf[5])&0xFF;
            tmDat.razm = buf[6] & 0xFF;
            tmDat.type = buf[7] & 0xF;
            switch (tmDat.type){
                case 0 -> tmDat.znachL = java.nio.ByteBuffer.wrap(new byte[]{0,0,0,0,buf[12],buf[13],buf[14],buf[15]}).getLong();
                case 1 -> tmDat.znachD = java.nio.ByteBuffer.wrap(new byte[]{buf[8],buf[9],buf[10],buf[11],buf[12],buf[13],buf[14],buf[15]}).getDouble();
                case 2 -> tmDat.znachC = java.nio.ByteBuffer.wrap(new byte[]{0,0,0,0,buf[12],buf[13],buf[14],buf[15]}).getLong();
                case 3 -> {
                    tmDat.znachP = java.nio.ByteBuffer.wrap(new byte[]{0,0,0,0,buf[12],buf[13],buf[14],buf[15]}).getLong();
                    int extraDataSize = ((buf[10] << 8)&0xFF00 | (buf[11]&0xFF)) - 4;
                    byte[] extraData = new byte[extraDataSize];
                    fin.read(extraData, 0, extraDataSize);
                }
            }
            if ((tmDat.num!=0xFFFF)) {
                list.add(tmDat);
            }
        }
    }
}









