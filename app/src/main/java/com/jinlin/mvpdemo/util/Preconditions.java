package com.jinlin.mvpdemo.util;

import io.reactivex.annotations.Nullable;

/*********************************************************
 * Preconditions
 * @author jinlin
 * @email jinlinsu@qq.com
 * @dete 2018/7/9
 *********************************************************/
public final class Preconditions {

    private Preconditions() {
        throw new IllegalStateException("你不能实例化我");
    }

    public static <T> T checkNotNull(T reference, @Nullable String errorMessageTemplate, @Nullable Object... errorMessageArgs) {

        if (reference == null) {
            throw new NullPointerException(format(errorMessageTemplate, errorMessageArgs));
        } else {
            return reference;
        }
    }

    public static int checkElementIndex(int index, int size, @Nullable String desc) {
        if (index > 0 && index < size) {
            return index;
        } else {
            throw new IndexOutOfBoundsException(badElementIndex(index, size, desc));
        }
    }

    private static String badElementIndex(int index, int size, String desc) {
        if (index < 0) {
            return format("%s (%s) must not be negative", new Object[]{desc, Integer.valueOf(index)});
        } else if (size < 0) {
            throw new IllegalArgumentException(new StringBuilder(26).append("negative size: ").append(size).toString());
        } else {
            return format("%s (%s) must be less than size (%s)", new Object[]{desc, Integer.valueOf(index), Integer.valueOf(size)});
        }
    }

    public static int checkPositionIndex(int index, int size, @android.support.annotation.Nullable String desc) {
        if (index >= 0 && index <= size) {
            return index;
        } else {
            throw new IndexOutOfBoundsException(badPositionIndex(index, size, desc));
        }
    }

    private static String badPositionIndex(int index, int size, String desc) {
        if (index < 0) {
            return format("%s (%s) must not be negative", new Object[]{desc, Integer.valueOf(index)});
        } else if (size < 0) {
            throw new IllegalArgumentException((new StringBuilder(26)).append("negative size: ").append(size).toString());
        } else {
            return format("%s (%s) must not be greater than size (%s)", new Object[]{desc, Integer.valueOf(index), Integer.valueOf(size)});
        }
    }

    static String format(String template, @Nullable Object... args) {
        template = String.valueOf(template);
        StringBuilder builder = new StringBuilder(template.length() + 16 * args.length);
        int templateStart = 0;

        int i;
        int placeholderStart;
        for (i = 0; i < args.length; templateStart = placeholderStart + 2) {
            placeholderStart = template.indexOf("%s", templateStart);
            if (placeholderStart == -1) {
                break;
            }
            builder.append(template.substring(templateStart, placeholderStart));
            builder.append(args[i++]);
        }

        builder.append(template.substring(templateStart));
        if (i < args.length) {
            builder.append("[");
            builder.append(args[i++]);
            while (i < args.length) {
                builder.append(", ");
                builder.append(args[i++]);
            }
            builder.append("]");
        }
        return builder.toString();
    }
}
