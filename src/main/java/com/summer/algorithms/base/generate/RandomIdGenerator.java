package com.summer.algorithms.base.generate;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Random;

/**
 * Id Generator that is used to generate random IDs
 *
 * The IDs generate by this class are not absolutely unique
 *
 * @author adminstor
 */
public class RandomIdGenerator implements LogTraceIdGenerator {
    @Override
    public String generate() {
        String id = "";
        try {
            String hostName = getLastFieldOfHostName();
            char[] randomChars = generateRandomAlphameric(8);
            id = String.format("%s-%d-%s", hostName, System.currentTimeMillis(), new String(randomChars));
            System.out.println(hostName);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return id;
    }

    protected char[] generateRandomAlphameric(int length) {
        char[] randomChars = new char[length];
        int count = 0;
        Random random = new Random();
        int maxAscii = 'z';
        while (count < length){
            int randomAscii = random.nextInt(maxAscii);
            boolean isDigit = randomAscii>='0' && randomAscii<='9';
            boolean isUppercase = randomAscii>='A' && randomAscii<='Z';
            boolean isLowercase = randomAscii>='a' && randomAscii<='z';
            if(isDigit || isLowercase || isUppercase){
                randomChars[count] = (char) randomAscii;
                count++;
            }
        }
        return randomChars;
    }

    private String getLastFieldOfHostName() throws UnknownHostException {
        String hostName = InetAddress.getLocalHost().getHostName();
        hostName = getLastSubstrSplittedByDot(hostName);
        return hostName;
    }

    protected String getLastSubstrSplittedByDot(String hostName) {
        String[] tokens = hostName.split("\\.");
        if(tokens.length>0){
            hostName = tokens[tokens.length-1];
        }
        return hostName;
    }
}
