SUMMARY = "Utilities for transponder dvb-c and dvb-s blindscan"
SECTION = "base"
PRIORITY = "optional"
LICENSE = "CLOSED"

PACKAGES = "miraclebox-blindscan-dvbs-utils-${MACHINE} miraclebox-blindscan-dvbc-utils-${MACHINE} miraclebox-blindscan-dvbs-utils-${MACHINE}-dbg miraclebox-blindscan-dvbc-utils-${MACHINE}-dbg"

PROVIDES += "virtual/blindscan-dvbs virtual/blindscan-dvbc"
RPROVIDES:miraclebox-blindscan-dvbs-utils-${MACHINE} += "virtual-blindscan-dvbs"
RPROVIDES:miraclebox-blindscan-dvbc-utils-${MACHINE} += "virtual-blindscan-dvbc"
RDEPENDS:miraclebox-blindscan-dvbc-utils-${MACHINE} += "libxml2"

SRC_URI = "file://ceryon-tda1002x file://ceryon_blindscan"

PV = "1.0"
PR = "r1"

S = "${WORKDIR}"

do_install() {
    install -d ${D}/${bindir}/
    install -m 0755 "${S}/ceryon-tda1002x" "${D}/${bindir}"
    install -m 0755 "${S}/ceryon_blindscan" "${D}/${bindir}"
}

FILES:miraclebox-blindscan-dvbs-utils-${MACHINE} = "${bindir}/*_blindscan"
FILES:miraclebox-blindscan-dvbc-utils-${MACHINE} = "${bindir}/ceryon-tda1002x"
FILES:miraclebox-blindscan-dvbs-utils-${MACHINE}-dbg = "${bindir}/.debug/*_blindscan"
FILES:miraclebox-blindscan-dvbc-utils-${MACHINE}-dbg = "${bindir}/.debug/ceryon-tda1002x"

INHIBIT_PACKAGE_STRIP = "1"

PACKAGE_ARCH = "${MACHINE_ARCH}"

INSANE_SKIP = "32bit-time ldflags"
