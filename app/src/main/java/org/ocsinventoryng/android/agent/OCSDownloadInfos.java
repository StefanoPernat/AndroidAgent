/*
 * Copyright 2013-2016, OCSInventory-NG/AndroidAgent contributors
 *
 * This file is part of OCSInventory-NG/AndroidAgent.
 *
 * OCSInventory-NG/AndroidAgent is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * OCSInventory-NG/AndroidAgent is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with OCSInventory-NG/AndroidAgent. If not, see <http://www.gnu.org/licenses/>
 */
package org.ocsinventoryng.android.agent;

public class OCSDownloadInfos {
    private String id;
    private int pri;
    private String act;
    private String digest;
    private String proto;
    private int frags;
    private String digest_algo;
    private String digest_encode;
    private String path;
    private String notify_text;
    private String notify_countdown;
    private boolean notify_user;
    private boolean notify_can_abort;
    private boolean notify_can_delay;
    private boolean need_done_action;
    private String need_done_action_text;


    OCSDownloadInfos(String strinfos) {
        id = extrAttr(strinfos, "ID");
        act = extrAttr(strinfos, "ACT");
        digest = extrAttr(strinfos, "DIGEST");
        proto = extrAttr(strinfos, "PROTO");
        digest_algo = extrAttr(strinfos, "DIGEST_ALGO");
        digest_encode = extrAttr(strinfos, "DIGEST_ENCODE");
        path = extrAttr(strinfos, "PATH");
        notify_countdown = extrAttr(strinfos, "NOTIFY_COUNTDOWN");
        notify_can_abort = extrAttr(strinfos, "NOTIFY_CAN_ABORT").equals("1");
        notify_can_delay = extrAttr(strinfos, "NOTIFY_CAN_DELAY").equals("1");
        need_done_action = extrAttr(strinfos, "NEED_DONE_ACTION").equals("1");
        need_done_action_text = extrAttr(strinfos, "NEED_DONE_ACTION_TEXT");
        try {
            pri = Integer.parseInt(extrAttr(strinfos, "PRI"));
        } catch (NumberFormatException e) {
        }

        try {
            frags = Integer.parseInt(extrAttr(strinfos, "FRAGS"));
        } catch (NumberFormatException e) {
        }
    }

    private String extrAttr(String doc, String attrName) {
        int x, y;
        x = doc.indexOf(attrName);
        x = doc.indexOf("\"", x);
        y = doc.indexOf("\"", x + 1);
        android.util.Log.i("extrattr", attrName + ":" + doc.substring(x + 1, y));
        return doc.substring(x + 1, y);
    }

    public String getId() {
        return id;
    }

    public int getPri() {
        return pri;
    }

    /**
     * @return action requested
     */
    public String getAct() {
        return act;
    }

    /**
     * @return digest value as string
     */
    public String getDigest() {
        return digest;
    }

    /**
     * @return protocol to use (HTTP/HTTPS)
     */
    public String getProto() {
        return proto;
    }

    /**
     * @return number of fragments
     */
    public int getFrags() {
        return frags;
    }

    public String getDigest_algo() {
        return digest_algo;
    }

    public String getDigest_encode() {
        return digest_encode;
    }

    public String getPath() {
        return path;
    }

    public boolean isNotify_user() {
        return notify_user;
    }

    public String getNotify_text() {
        return notify_text;
    }

    public String getNotify_countdown() {
        return notify_countdown;
    }

    public boolean isNotify_can_abort() {
        return notify_can_abort;
    }

    public boolean isNotify_can_delay() {
        return notify_can_delay;
    }

    public boolean isNeed_done_action() {
        return need_done_action;
    }

    public String getNeed_done_action_text() {
        return need_done_action_text;
    }
}
