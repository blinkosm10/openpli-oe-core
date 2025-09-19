SUMMARY = "image update support"
SECTION = "base"
PRIORITY = "required"
MAINTAINER = "xtrend"
LICENSE = "proprietary"
PACKAGE_ARCH = "${MACHINE_ARCH}"

require conf/license/license-gplv2.inc

PR = "r1"
ALLOW_EMPTY:${PN} = "1"

SRC_URI = "http://downloads.openpli.org/archive/gi/vmlinuz-initrd-${MACHINE}-${SRCDATE}.zip"

FILES:${PN} = "/boot"

S = "${WORKDIR}"
