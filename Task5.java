import java.util.List;

class Document {
    public String extractContent() { return ""; }
}

class ValidationResult {
    private boolean valid;
    private String message;

    public static ValidationResult invalid(String msg) {
        ValidationResult r = new ValidationResult();
        r.valid = false;
        r.message = msg;
        return r;
    }

    public boolean isValid() {
        return valid;
    }
}

public class Task5 {

    public ValidationResult validate(Document doc) {
        try {
            if (doc == null) {
                // FIX: Proper exception type
                throw new IllegalArgumentException("Document is null");
            }

            String content = doc.extractContent();

            if (content == null || content.isEmpty()) {
                // FIX: Expected validation case
                return ValidationResult.invalid("Empty content");
            }

            return runValidationRules(content);

        } catch (IllegalArgumentException e) {
            // FIX: Avoid stack trace flooding
            System.out.println("Validation failed: " + e.getMessage());
            return ValidationResult.invalid(e.getMessage());

        } catch (Exception e) {
            // FIX: Log unexpected errors
            e.printStackTrace();
            return ValidationResult.invalid("Unexpected error");
        }
    }

    public void validateBatch(List<Document> docs) {
        for (Document doc : docs) {
            try {
                ValidationResult r = validate(doc);

                // FIX: Null check
                if (r != null && r.isValid()) {
                    saveResult(r);
                }

            } catch (Exception e) {
                // FIX: Do not swallow exception
                e.printStackTrace();
            }
        }
    }

    private ValidationResult runValidationRules(String content) {
        return new ValidationResult();
    }

    private void saveResult(ValidationResult r) {}
}
