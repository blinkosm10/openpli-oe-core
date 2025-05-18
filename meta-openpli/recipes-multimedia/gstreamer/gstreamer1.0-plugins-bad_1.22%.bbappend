FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

PV = "1.26.1"

SRC_URI[sha256sum] = "9b8415b1bb3726a499578fb39907952981716643f660215fe68628fbd8629197"

SRC_URI:append = "file://001-rtmp-hls-tsdemux-fix.patch \
                  file://003-rtmp-fix-seeking-and-potential-segfault.patch \
"

PACKAGECONFIG = "${GSTREAMER_ORC} bz2 closedcaption curl dash dtls faac faad hls openssl opusparse \
                 rsvg rtmp sbc smoothstreaming sndfile ttml uvch264 webp \
"

EXTRA_OEMESON:remove = "-Dkate=disabled"
