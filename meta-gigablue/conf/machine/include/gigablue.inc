KERNEL_MODULE_AUTOLOAD += "xfs"

# We know about rtc
MACHINE_FEATURES_BACKFILL_CONSIDERED = "rtc"

IMAGEVERSION := "${DISTRO_NAME}-${DISTRO_VERSION}-${DATE}"
IMAGEVERSION[vardepsexclude] = "DATE"

MACHINE_FEATURES += "3dtv alsa hdmicec switchoff"

MACHINE_DRIVER = "\
${@bb.utils.contains('MACHINE', 'gbquad4k', 'gb7252' , '', d)}\
${@bb.utils.contains('MACHINE', 'gbquad4kpro', 'gb7252pro' , '', d)}\
${@bb.utils.contains('MACHINE', 'gbue4k', 'gb7252' , '', d)}\
${@bb.utils.contains('MACHINE', 'gbtrio4k', 'gbtrio4k' , '', d)}\
${@bb.utils.contains('MACHINE', 'gbtrio4kpro', 'gbtrio4kpro' , '', d)}\
"
