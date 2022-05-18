package com.favtuts.io.howto;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;

public class SFTPFileTransfer {

    private static final String REMOTE_HOST = "1.2.3.4";
    private static final String USERNAME = "";
    private static final String PASSWORD = "";
    private static final int REMOTE_PORT = 22;
    private static final int SESSION_TIMEOUT = 10000;
    private static final int CHANNEL_TIMEOUT = 5000;

    public static void main(String[] args) {
        
        // local
        String localFile = "/home/mkyong/hello.sh";

        // remote server
        String remoteFile = "/home/mkyong/test.sh";

        Session jschSession = null;

        try {
            JSch jsch = new JSch();
            jsch.setKnownHosts("/home/favtuts/.ssh/known_hosts");
            jschSession = jsch.getSession(USERNAME, REMOTE_HOST, REMOTE_PORT);

            // authenticate using private key
            // jsch.addIdentity("/home/favtuts/.ssh/id_rsa");

            // authenticate using password
            jschSession.setPassword(PASSWORD);

            // 10 seconds session timeout
            jschSession.connect(SESSION_TIMEOUT);

            Channel sftp = jschSession.openChannel("sftp");

            // 5 seconds timeout
            sftp.connect(CHANNEL_TIMEOUT);

            ChannelSftp channelSftp = (ChannelSftp) sftp;

            // transfer file from local to remote server
            channelSftp.put(localFile, remoteFile);

            // download file from remote server to local
            // channelSftp.get(remoteFile, localFile);

            channelSftp.exit();
        } catch (JSchException | SftpException e) {

            e.printStackTrace();

        } finally {
            if (jschSession != null) {
                jschSession.disconnect();
            }
        }
    }

}
