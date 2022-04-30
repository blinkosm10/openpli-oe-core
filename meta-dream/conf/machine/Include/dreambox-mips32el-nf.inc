# dreambox-mips32el-nf.inc

KERNELVERSION = "2.6.18"

BOX_BRAND = "dreambox"

TARGET_ARCH = "mipsel"
DEFAULTTUNE = "mips32el-nf"

MTD_KERNEL = "mtd2"

KERNEL_FILE = "kernel.bin"
ROOTFS_FILE = "rootfs.bin"

MACHINE_FEATURES_BACKFILL_CONSIDERED += "rtc"

OPTIONAL_BSP_PACKAGES += "dreambox-buildimage"
EXTRA_IMAGEDEPENDS += "dreambox-secondstage-${MACHINE}"

MACHINE_ESSENTIAL_EXTRA_RDEPENDS += "\
	dm-bootsplash \
	dm-shutdown \
	dm-startupfix \
	dreambox-boot-progress \
	dreambox-dvb-modules-${MACHINE} \
	kernel-module-md4 \
	v4l-dvb-module-dvb-core \
	v4l-dvb-module-stv0299 \
	"

GLIBC_EXTRA_OECONF = "--with-tls --with-__thread"
DVBMEDIASINK_CONFIG = "--with-dts=no"
OLDEST_KERNEL = "${KERNELVERSION}"
GLIBCVERSION_dm800 = "2.19"
PREFERRED_VERSION_glibc_dm800 = "2.19"
PREFERRED_VERSION_glibc-initial_dm800 = "2.19"

PREFERRED_VERSION_kernel-module-extrawlan-rtl8192cu = "3.3.0"
PREFERRED_VERSION_libnl = "3.2.24"
PREFERRED_VERSION_linux-dreambox = "${KERNELVERSION}"
PREFERRED_VERSION_linux-libc-headers = "${KERNELVERSION}"
PREFERRED_VERSION_wscan = "20130331"

MACHINE_FEATURES += "alsa usbhost switchoff dreambox oldkernel olde2api DVI wifiusblegacy"

PREFERRED_PROVIDER_virtual/bootloader = "dreambox-secondstage-${MACHINE}"
PREFERRED_PROVIDER_virtual/kernel = "linux-dreambox"

PREFERRED_PROVIDER_virtual/blindscan-dvbs = "dreambox-blindscan-utils"
PREFERRED_PROVIDER_virtual/blindscan-dvbc = "dreambox-blindscan-utils"

KERNEL_IMAGETYPE = "vmlinux"
KERNEL_OUTPUT = "${KERNEL_IMAGETYPE}"
KERNEL_OUTPUT_DIR = "."
KERNEL_CONSOLE = "${@bb.utils.contains('MACHINE_FEATURES', 'usbconsole', 'ttyS0,115200', 'null', d)}"

DREAMBOX_BUILDIMAGE = "buildimage --arch ${MACHINE} ${EXTRA_BUILDCMD} \
	--erase-block-size ${DREAMBOX_ERASE_BLOCK_SIZE} \
	--flash-size ${DREAMBOX_FLASH_SIZE} \
	--sector-size ${DREAMBOX_SECTOR_SIZE}"

require conf/machine/include/tune-mips32.inc

require conf/machine/include/dreambox-brcmnand.inc
require conf/machine/include/dreambox-nand-64mb.inc
require conf/machine/include/dreambox-part-64mb.inc
require conf/machine/include/dreambox-jffs2.inc

SOC_FAMILY = "bcm7401"
DVBPROVIDER = "v4l-dvb"

# Image fails to boot if kernel exceeds some unknown limit, so make that
# explicit here. I don't know what the actual limit is, but 6416679 boots
# and 6604470 didn't.
KERNEL_IMAGE_MAXSIZE = "6500000"

CFLAGS_append_pn-titan = " -DDREAMBOX "
