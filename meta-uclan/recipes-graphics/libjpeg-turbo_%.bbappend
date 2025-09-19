FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

PACKAGE_ARCH = "${MACHINE_ARCH}"

SRC_URI:append:ustym4ks2ottx = " \
	file://libjpeg.so.8.2.2 \
"

do_install:append:ustym4ks2ottx() {
	install -d ${D}${libdir}
	install -m 0755 ${WORKDIR}/libjpeg.so.8.2.2 ${D}${libdir}/
	ln -s libjpeg.so.8.2.2 ${D}${libdir}/libjpeg.so.8
}
