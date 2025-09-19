SUMMARY = "Utilities for transponder & dvb-s/c blindscan"
SECTION = "base"
PRIORITY = "optional"
LICENSE = "CLOSED"

PACKAGE_ARCH = "${MACHINE_ARCH}"

PACKAGES = "edision-blindscan-dvbs-utils-${MACHINE} edision-blindscan-dvbc-utils-${MACHINE}"

PROVIDES += "virtual/blindscan-dvbs virtual/blindscan-dvbc"
RPROVIDES:edision-blindscan-dvbs-utils-${MACHINE} += "virtual-blindscan-dvbs"
RPROVIDES:edision-blindscan-dvbc-utils-${MACHINE} += "virtual-blindscan-dvbc"

SRC_URI = "http://downloads.openpli.org/archive/edision/edision-blindscan-utils-${PV}.zip"

S = "${WORKDIR}"
BLINDSCANARCH ?= ""
BLINDSCANARCH:arm = "arm-linux-gnueabihf"
BLINDSCANARCH:aarch64 = "aarch64-linux-gnu"
BLINDSCANARCH:mipsel = "mipsel-linux-gnu"

FILES:edision-blindscan-dvbs-utils-${MACHINE} = "${bindir}/blindscan"
FILES:edision-blindscan-dvbc-utils-${MACHINE} = "${bindir}/tda1002x"

INSANE_SKIP:${PN} += "already-stripped"

do_install() {
	install -d ${D}${bindir}
	install -m 0755 ${S}/${BLINDSCANARCH}/tda1002x ${D}${bindir}
	install -m 0755 ${S}/${BLINDSCANARCH}/blindscan ${D}${bindir}
}
