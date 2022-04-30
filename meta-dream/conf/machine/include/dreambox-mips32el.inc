# dreambox-mips32el.inc

BOX_BRAND = "dreambox"

TARGET_ARCH = "mipsel"
DEFAULTTUNE = "mips32el"

MACHINE_ESSENTIAL_EXTRA_RDEPENDS += "\
	dm-bootsplash \
	kernel-module-stv0299 \
	libpagecache \
	libpassthrough \
	"

MTD_KERNEL = "mtd2"

require conf/machine/include/dreambox.inc
require conf/machine/include/tune-mips32.inc

DVBMEDIASINK_CONFIG = "--with-pcm --with-wma --with-wmv --with-dtsdownmix --with-eac3 --with-dts"

KERNELVERSION = "3.2"

FLASHSIZE = "64"

require conf/machine/include/dreambox-brcmnand.inc
require conf/machine/include/dreambox-nand-64mb.inc
require conf/machine/include/dreambox-part-64mb.inc
require conf/machine/include/dreambox-jffs2.inc

PREFERRED_VERSION_wscan = "20130331"
PREFERRED_VERSION_linux-dreambox = "${KERNELVERSION}"

SOC_FAMILY = "bcm7405"

# Image fails to boot if kernel exceeds some unknown limit, so make that
# explicit here. I don't know what the actual limit is, but 6416679 boots
# and 6604470 didn't.
KERNEL_IMAGE_MAXSIZE = "6500000"

MACHINE_FEATURES += "fan hdmicec HDMI"

CFLAGS_append_pn-titan = " -DDREAMBOX "

KERNEL_FILE = "kernel.bin"
ROOTFS_FILE = "rootfs.bin"
