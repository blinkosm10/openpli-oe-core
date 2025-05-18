FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

RDEPENDS:libgstgl-1.0 = "libGLESv2.so"

PV = "1.26.1"

SRC_URI[sha256sum] = "659553636f84dcf388cad5cf6530e02b0b2d3dc450e76199287ba9db6a6c5226"

SRC_URI:append = " file://001-riff-media-added-fourcc-to-all-ffmpeg-mpeg4-video-caps.patch \
                   file://002-subparse-avoid-false-negatives-dealing-with-UTF-8.patch \
                   file://define-surfaceless-mesa-macro.patch \
"
SRC_URI:remove = "file://0004-vorbisdec-Set-at-most-64-channels-to-NONE-position.patch \
                  file://0005-opusdec-Set-at-most-64-channels-to-NONE-position.patch \
                  file://0006-vorbis_parse-check-writes-to-GstOggStream.vorbis_mod.patch \
                  file://0007-oggstream-review-and-fix-per-format-min_packet_size.patch \
                  file://0008-ssaparse-Search-for-closing-brace-after-opening-brac.patch \
                  file://0009-ssaparse-Don-t-use-strstr-on-strings-that-are-potent.patch \
                  file://0010-id3v2-Don-t-try-parsing-extended-header-if-not-enoug.patch \
                  file://0011-discoverer-Don-t-print-channel-layout-for-more-than-.patch \
                  file://0012-subparse-Check-for-NULL-return-of-strchr-when-parsin.patch \
"

PACKAGECONFIG = "${GSTREAMER_ORC} alsa jpeg ogg opus pango png theora vorbis"
