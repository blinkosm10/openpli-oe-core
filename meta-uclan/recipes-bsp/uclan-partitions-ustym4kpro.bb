SUMMARY = "ustym4kpro partitions files"
SECTION = "base"
PRIORITY = "required"
LICENSE = "CLOSED"
PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit deploy

SRCDATE = "20220326"
PR = "${SRCDATE}"

S = "${WORKDIR}/patitions"

SRC_URI = "\
    http://downloads.openpli.org/archive/uclan/${MACHINE}-partitions-${SRCDATE}.zip \
    file://logo.img \
"

ALLOW_EMPTY:${PN} = "1"
do_configure[nostamp] = "1"
do_install[noexec] = "1"

FILES:${PN} = "/usr/share"

do_deploy() {
    install -d ${DEPLOY_DIR_IMAGE}/${MACHINE}-partitions
    install -m 0755 ${S}/bootargs.bin ${DEPLOY_DIR_IMAGE}/${MACHINE}-partitions
    install -m 0755 ${S}/boot.img ${DEPLOY_DIR_IMAGE}/${MACHINE}-partitions
    install -m 0755 ${S}/fastboot.bin ${DEPLOY_DIR_IMAGE}/${MACHINE}-partitions
    install -m 0755 ${S}/apploader.bin ${DEPLOY_DIR_IMAGE}/${MACHINE}-partitions
    install -m 0755 ${S}/pq_param.bin ${DEPLOY_DIR_IMAGE}/${MACHINE}-partitions
    install -m 0755 ${S}/emmc_partitions.xml ${DEPLOY_DIR_IMAGE}/${MACHINE}-partitions
    install -m 0755 ${S}/baseparam.img ${DEPLOY_DIR_IMAGE}/${MACHINE}-partitions
    install -m 0755 ${WORKDIR}/logo.img ${DEPLOY_DIR_IMAGE}/${MACHINE}-partitions
    install -m 0755 ${S}/deviceinfo.bin ${DEPLOY_DIR_IMAGE}/${MACHINE}-partitions
}

addtask deploy before do_build after do_install

SRC_URI[md5sum] = "a43f9f0c79a4d898c019091eb72cb7f2"
SRC_URI[sha256sum] = "450af10ee881976b50f78896a4989903104826729b4ca9bc75edfada359a656b"

INSANE_SKIP:${PN} += "already-stripped"
