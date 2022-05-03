SUMMARY = "Utilities needed to do transponder blindscan with dreambox dvb receivers"
LICENSE = "CLOSED"

PROVIDES += "virtual/blindscan-dvbs virtual/blindscan-dvbc"
RPROVIDES_${PN} += "virtual/blindscan-dvbs virtual/blindscan-dvbc"

DEPENDS = "ncurses"

PV = "${@bb.utils.contains("MACHINE", "dm800", "1.9", "1.12", d)}"

SRC_URI_dm800 += "http://dreamboxupdate.com/download/opendreambox/2.0.0/blindscan-utils/blindscan-utils_1.9_${DEFAULTTUNE}.tar.bz2;name=${DEFAULTTUNE}-denzil"
SRC_URI += "http://dreamboxupdate.com/download/opendreambox/2.2.0/blindscan-utils/${PV}/${DEFAULTTUNE}/2acb58192434f308bfed6879c51d5d6e/blindscan-utils_${PV}_${DEFAULTTUNE}.tar.xz;name=${DEFAULTTUNE}-dora"

S = "${WORKDIR}/blindscan-utils_${PV}_${DEFAULTTUNE}"

PACKAGES = "${PN}"

SRC_URI[mips32el-nf-denzil.md5sum] = "143cb7253132af1ecd3aafa3679c6109"
SRC_URI[mips32el-nf-denzil.sha256sum] = "53d2760e3aa19eab6e19edabe8b9dd840c693ca30c43495904241e52fd40ea32"

do_install() {
    cp -r * ${D}
}

INHIBIT_PACKAGE_STRIP = "1"
PACKAGE_ARCH = "${MACHINE_ARCH}"
